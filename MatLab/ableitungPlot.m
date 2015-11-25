
h = 10.^(-2:-.1:-12);

r = zeros(1,60);

q=1;

while(q <= 60)
    
   r(q) = ableitung(q);
    
    q = q + 1;
end

r