x = .1:10;
y = log10(.1:10);

plot(x,y,'g*')

%Design option:

h = title('Plot of Log 10');
h(2) = xlabel('Timestep');
h(3) = ylabel('Value of log10');

set(h(2:3),'FontSize',13);
