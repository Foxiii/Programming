t=0:0.01:1;

f1=sin(2*pi*t);
f2=cos(2*pi*t);

plot(t,f1,'b',t,f2,'r*') %Plot

%Design options:

h= title('Sinus and Cosinus');
h(2)=xlabel('Time');
h(3) = ylabel('Value');
h(4) = legend('Sinus','Cosinus');

%Font options

set(h(1),'FontSize',16);
set(h(2:3),'FontSize',13);
set(h(4),'FontSize',13);
set(h,'FontWeight','bold');