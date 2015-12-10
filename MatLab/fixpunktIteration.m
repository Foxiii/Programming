function [x] = fixpunktIteration(x , n )

for i = 1:n   ;
    x = 1/(1+x^2);    
end

end

