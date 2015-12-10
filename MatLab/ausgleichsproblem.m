%Hausaufgabe Arbeitsblatt 5 Nr. 4 a)
function x =  ausgleichsproblem(A,b) %EIngabe Matrix A und Vektor b

[Q,R] = qr(A);  %Lasse Matlab QR-Zerlegung durchführen

n = rank(A);
b = Q'*b ;       %Multipliziere Q'*b für die Anpassung des b Vektors.
                 %Q' aufgrund der Berechnungsart von Q in Matlab

b = b(1:n) ;     %Nur die ersten n Zeilen von b.
R = R(1:n ,:) ;   %Nur die ersten n Zeilen von R.

x = R\b ;



