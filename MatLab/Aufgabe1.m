%a

A = [3,1,0;1,2,0;0,1,2];
B = diag(2:2:4,1);
C = 3* eye(3);

%b

2*A+3*B^2+C^2

%c

v = [1,2,3];
v= v';

A\v

%d

A\eye(size(A))

%e

D = [A , B ; C , A]