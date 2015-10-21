%Exercise 2

function fibonacci(n)

f1 = 1;
f2 = 1;
x = n;

while(n > 2)
    
    fn = f1 + f2 ;
    
    f1 = f2 ;
    f2 = fn;
    n = n-1;
end

disp(['The Fib of ',num2str(x),' is: ' ,num2str(fn)])
    