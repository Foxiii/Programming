

x = -2:.01:2;
f1 = x.^2;
f2 = x.^3;


figure(3);
subplot(2,1,1);
plot(x,f1);

title('x^2 in a subplot');
xlabel('Time');
ylabel('Value');

subplot(2,1,2);
plot(x,f2,'r');

title('x^3 in a subplot');
xlabel('Time');
ylabel('Value');