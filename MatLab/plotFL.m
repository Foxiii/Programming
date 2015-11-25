function plotFL()

format long         %bessere Ausgabegenauigkeit.
s= 2;               %Z�hler f�r 10^(-2) bis 10^(-12).
r = 2;              %Ausgabe f�r fprintf.
counter = 0;        %Counter um fprintf Ausgabe zur�ck zu setzen.
vect = zeros(1,60); %Ausgabevektor f�r einzelnen Ableitungen.
count = 1;

%Position des Ableitungsvektor.
while(s <= 12)      %Z�hler von 10^(-2) bis 10^(-12).
 h= 10^(-s);        %Setze h auf Wert. 

 
 %Durch weiters ableiten erh�lt man f�r f''(x) =
 %(f(x+h)+2*f(x)*f(x-h)/ h^2)
 
approx = ((sin(1+h)-2*sin(1)+sin(1-h))/(h^2)); %x = 1 um den Punkt h

%Berechnung des relativen Fehlers von f(x)
er = abs(((((sin(1+h)-2*sin(1)+sin(1-h))/(h^2)) + sin(1)) / sin(1)) ); 
vect(count) = er;                    %Bef�llen des Ausgabevectors.
er = abs(er);                        %Absolutbetrag (Nur f�r Printf)

fprintf('Value of second derivation  at h = %.16f  :: 10^(-%d) : Approximation: %.16f   , Error: %.16f \n',h,r,approx , er) ;


s = s + 0.1;                         %Erh�hung der s Variablen
count = count + 1;                   %Erh�hung des Counters
%Ausgabe 10^(r) counter um 0.1 Schritte auszugleichen
if counter == 10;                    
   r = r+1; 
   counter = 1;
end
counter= counter +1;
end

%h Vektor nocheinaml f�r den Plot erzeugen da obige Funktion nicht mit Vektoren.
%arbeiten kann.

h= 10.^(-2:-0.1:-12);  

%Ausgabe als logarithmischer Plot (Optimal ist hier ca. 10^-4)
%Das optimal h von Aufgabe 3b stimmt nicht exakt mit dem optimalen h
%von Aufgabe 3c �berein. Dies liegt daran, dass in Aufgabe 3c die Funktion
%noch einmal abgeleitet wird und sich somit das optimal h nocheinmal 
%verschiebt.

subplot(3,1,1);
loglog(h,vect)
title('Log Plot')
xlabel('h')
ylabel('Num. Ableitung f^(2)(x)')

%Zoom Plot
subplot(3,1,2);
plot(h,vect)
title('Plot')
xlabel('h')
ylabel('Num. Ableitung f^(2)(x)')

%Plot �ber h
subplot(3,1,3);
plot(h,vect)
title('Plot')
xlabel('h')
ylabel('Num. Ableitung f^(2)(x)')

