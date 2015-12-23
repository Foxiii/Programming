function compIterations(x0,x1,n)
format long;
s = 0.6823278038280193273694;

for i = 1:n
    a(i) = abs(fixpunktIteration(x0,i) - s);
    b(i) = abs(newtonIteration(x0,i) - s);
    c(i) = abs(bisektionIteration(x0,x1,i) - s);
end

x = 1:n;
semilogy(x,a,'*');

hold on; % muss hinter dem "initialisierren" des Koordinatensystems stehen

semilogy(x,b,':');
semilogy(x,c,'--');

legend('Banach','Newton','Bisektion');

xlabel('iterations');
ylabel('absolute error');

set(gca,'xtick',[1:15]);
set(gca,'yscale','log');

end

