function [ I ,DUI ] = entrauschen()
 I = double(imread('bilder\rau.bmp', 'BMP'));
 I = I / 255;
D = size(I);
n = D(1,1);
m = D(1,2);

for z = 1:250
[DUI, DDI] = kantendetektion(255* I);
DUI = double(DUI);
    %Kleiner aufgrund meiner Skalierung der Matrixwerte!
   DUI = 0.0006 * DUI;
   I = I + DUI;
end


