function plotFL()



s= 2;

r = 2
counter = 0;

while(s <= 12)

 h= 10^(-s);
 

approx = ((sin(1+h)-2*sin(1)+sin(1-h))/(h^2));

er = ((sin(1+h)-2*sin(1)+sin(1-h))/(h^2)) + sin(1);

er = abs(er);

fprintf('Value of second derivation  at h = %.16f  :: 10^(-%d) : Approximation: %.16f   , Absolut Error: %.16f \n',h,r,approx , er) ;

s = s + 0.1;

if counter == 10;
   r = r+1; 
   counter = 1;
end
counter= counter +1;

end
