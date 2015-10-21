%Matrix multiplication with for loop

function [matrix] = matrixmultiplication(A,B)

DimA = size(A);
DimB = size(B);
temp = 0;

if(DimA(1,2)==DimB(1,1));
    
    matrix = zeros(DimA(1,1),DimB(1,2));
    
    for y = 1 : DimA(1,1);
        
        for p = 1 : DimB(1,2);
            
        for x = 1 : DimA(1,2);
            
            temp = temp + (A(y,x) * B(x,p));
        end
        
        matrix(y,p) = temp;
        temp = 0;
        end
    end
        
else
    
    disp('Wrong size of Matrix!')
    
end
