
%b
R = zeros(6);
z = 5;

for i = 1:5
    v = z * ones(1,i);
    R = R + diag(v,-z);
    R = R + diag(v,z);
    
    z = z-1;
    
end

R