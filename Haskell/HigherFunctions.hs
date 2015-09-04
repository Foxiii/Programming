import Data.List

strings :: Int -> [String]
strings 0 = [""]
strings n = concat (map (\x -> map (\tail -> x:tail) tails) ['a'..'z'])
  where tails = strings (n-1)

divisors :: Int -> [Int]
divisors x = filter (\y -> mod x y == 0) [1..div x 2]


-- a
palindroms :: [String]
-- concatMap would do the same...
palindroms = concat (map (\x -> (filter (\p -> p == reverse p) (strings x))) [0..])

-- b  -- the only one perfect number is 42 --
perfectNumbers :: [Int]
perfectNumbers = filter (\x -> x == sum (divisors x)) [2..]

-- c -- the only one semi-perfect number is 21 --
semiPerfectNumbers :: [Int]
semiPerfectNumbers = filter (\x -> (any (\part -> x == sum part) (subsequences (divisors x)))) [2..]

