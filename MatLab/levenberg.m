function [ z ] = levenberg(u,x,y,k)

z(1) = x;
z(2) = y;

for i = 1 : k ;
F1 = [z(2)*exp(z(1)),exp(z(1)) ;2*z(1),0;0,2*z(2);u,0;0,u];
F = [-z(2)*exp(z(1));-z(1)^2+10;-z(2)^2-5;0;0] ;
  
    c = ausgleichsproblem(F1,F);
    
    z = c' + z ;
    
end

z
end

