function [ T] = kantendetektionBild(x,y)
%imshow(kantendetektionBild(-70,40))
 [I ,DI ] = kantendetektion(imread('bilder\camera.bmp'));
 
 D = size(I);
n = D(1,1);
m = D(1,2);



for i = 1:n;
for j = 1:m;
    if I(i,j) > x && I(i,j) < y
        T(i,j) = 1;
    else
        T(i,j) = 0;
    end
end
end
end

