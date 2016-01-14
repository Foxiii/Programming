function [ DUI , DDI ] = kantendetektion(I)

%Umwandeln der Matrix I in double
I = double(I);
%I = I / 255;
%Festlegen von m und n (Dimension der Matrix)
D = size(I);
n = D(1,1);
m = D(1,2);

%Füllen der neuen Matrix mit nullen
DDI = zeros(n,m);
DUI = zeros(n,m);

% 2.1 Randbedingungen Erweitere die Matrix wie in 2.1 beschrieben
I1 = I(1,:);
I = [I1;I];
I2 = I(end,:);
I = [I;I2];
I3 = I(:,1);
I = [I3,I];
I4 = I(:,n);
I = [I,I4];

%Aufstellen des Gradienten
for i = 2:n+1;
for j = 2:m+1;
    T1 = (1/2*(I(i+1,j)-I(i,j) + I(i+1,j+1) - I(i,j+1)));
    T2 = (1/2*(I(i,j+1)-I(i,j) + I(i+1,j+1) - I(i+1,j)));
    %Multiplikation von Gradient^T * Gradient
    DDI(i-1,j-1) = [T1,T2] * [T1;T2];    
end
end

%Differenzenquotient berechnen
for i = 2:n+1;
for j = 2:m+1;
    %Formel aus Tabelle 2
    DUI(i-1,j-1) = I(i,j+1)+I(i,j-1)+I(i+1,j)+I(i-1,j)-4*I(i,j);
end
end


