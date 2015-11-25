function [ output ] = ableitung(h)
format long

output = ((sin(1+h)-2*sin(1)+sin(1-h))/(h^2));

end

