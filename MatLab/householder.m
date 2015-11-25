function [R,v] = householder(A)
[m,n] = size(A);
if m>=n,
    NumberOfReflections = n;
else
    NumberOfReflections = m-1;
end
R = A;
v = cell(NumberOfReflections,1);
for k = 1:NumberOfReflections,
    x = R(k:m,k);
    xnorm = norm(x);
    if xnorm>=0,
        % Compute the normal vector of the reflector
        v{k} = x;
        v{k}(1) = v{k}(1) + sign(-1)*xnorm;
        v{k} = (sqrt(2)/norm(v{k}))*v{k};

        % Update R
        for j = k:NumberOfReflections,
                R(k:m,j) = R(k:m,j) - (v{k}'*R(k:m,j))*v{k};
        end
    else
        v{k} = zeros(m-k+1,1);
    end
end