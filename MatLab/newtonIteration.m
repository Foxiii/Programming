function [x] = newtonIteration(x , n )

for i = 1:n   ;
    x = (3*x^2+1)/(x^4+2*x^2+2*x+1);    
end

end