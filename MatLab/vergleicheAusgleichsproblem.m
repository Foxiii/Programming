%Arbeitsblatt 5 Aufgabe 4 c)

%Eingabe Sigma
%Ausgabe q Fehlervektor �ber QR-Zerlegung , n Fehlervekotr �ber Normalgleichung
function [q , n] =vergleicheAusgleichsproblem(s) 


A = [2,2,3;1,1,2;1,1,2;0,s,-2];
b = [5;2;4;-1];
x = [1-(1/s);1/s ; 1];


q =  norm(ausgleichsproblem(A,b)-x ,2) / norm(ausgleichsproblem(A,b),2);
n =  norm(ausgleichsproblemNG(A,b)-x ,2) / norm(ausgleichsproblemNG(A,b),2);

%d) 

%Q ist immer stabil gr��e des Fehlers * 10^-16 ist maximalen Wert den wir
%erwarten k�nnen.

%n f�r sehr kleine s absolut nicht stabil!