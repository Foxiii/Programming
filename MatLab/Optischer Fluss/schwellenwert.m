%Enter x as SCHWELLENWERT and A as Matrix to detect.
%Für zwei Kreise nutze imshow(schwellenwert(15,50,DUI))
%Für großen Kreis nutze imshow(schwellenwert(-18,-2,DUI))

function [ T ] = schwellenwert( x, y, I )

D = size(I);
n = D(1,1);
m = D(1,2);



for i = 1:n;
for j = 1:m;
    if I(i,j) > x && I(i,j) < y
        T(i,j) = 0;
    else
        T(i,j) = 1;
    end
end
end

end

