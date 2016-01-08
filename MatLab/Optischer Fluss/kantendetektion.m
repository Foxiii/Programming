function [ DUI , DDI ] = kantendetektion(I)

%Skalierung Gradient  imshow(255*DDI)

I = double(I);
%I = I / 255;
D = size(I);
n = D(1,1);
m = D(1,2);

DDI = zeros(n,m);
DUI = zeros(n,m);

% 2.1 Randbedingungen Erweitere die Matrix A = I um Zeilte 0 und Spalte n+1
I1 = I(1,:);
I = [I1;I];
I2 = I(end,:);
I = [I;I2];
I3 = I(:,1);
I = [I3,I];
I4 = I(:,n);
I = [I,I4];

for i = 2:n+1;
for j = 2:m+1;
    T1 = (1/2*(I(i+1,j)-I(i,j) + I(i+1,j+1) - I(i,j+1)));
    T2 = (1/2*(I(i,j+1)-I(i,j) + I(i+1,j+1) - I(i+1,j)));
    
    DDI(i-1,j-1) = [T1,T2] * [T1;T2];    
end
end

for i = 2:n+1;
for j = 2:m+1;
    DUI(i-1,j-1) = I(i,j+1)+I(i,j-1)+I(i+1,j)+I(i-1,j)-4*I(i,j);
end
end


