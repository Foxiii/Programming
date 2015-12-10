function compIterations(x0,x1,n)
format long;
s = 0.6823278038280193273694;

for i = 1:n
   
    a(i)  = abs(fixpunktIteration(x0,i))-s;
    b(i) = abs(newtonIteration(x0,i))-s;
    c(i) = abs(bisektionIteration(x0,x1,i))-s;
    
      
end
hold on;

x = 1:n;
loglog(x,a);
loglog(x,b);
loglog(x,c);
legend('Banach','Newton','Bisektion');

end

