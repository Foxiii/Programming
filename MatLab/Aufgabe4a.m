%a

C = zeros(6);
z = 0;
i= 0;

for x=1:6 
    
    for y = x:6
        
        C(x,y) = i;
        C(y,x) = i;
        i = i +1;
    end    
    i = 0;
end
   C
