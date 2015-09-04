% a
prime(N) :- N > 1,                            % prime is greater than 1
            infactorable(N,2).                % primes factors: 1,itself

infactorable(N,N).                            % case if N is prime
infactorable(N,D) :- (N > D + 1; N is D + 1), % other cases (N > 2)
                     0 < (N mod D),           % proove no other factors
                     Z is D + 1,              % increase divisor
                     infactorable(N,Z).       % recursive call

% b
only_primes([L|[]]) :- prime(L).              % tail empty or only one element
only_primes([L|LS]) :- prime(L),              % head of list is prime
                       only_primes(LS).       % recursive call
