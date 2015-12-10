function [x] = bisektionIteration(x0 , x1 , n )

a = x0;
b = x1;

for i = 1:n;
    
    x = (a+b)/2;    
  fx = (1/(1+x^2)) -x;
  fa = (1/(1+a^2)) -a;
  
  if (fx * fa) <= 0
   
    b = x;      
  else
      a = x;
     
  end
     
end
   
end
