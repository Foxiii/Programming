function [ I ,DUI ] = entrauschen()
%Einlesen des Bildes
 I = double(imread('bilder\rau.bmp', 'BMP'));
 I = I / 255;
D = size(I);
n = D(1,1);
m = D(1,2);

for z = 1:250
    %Entrauschen des Bildes ueber die bereits vorhandenen Funktionen
[DUI, DDI] = kantendetektion( I);
DUI = double(DUI);
   
   DUI = 0.006 * DUI;
   I = I + DUI;
end


