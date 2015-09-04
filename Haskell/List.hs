data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil)))) -- entspricht [-3,14,-6,7,1]

bList :: List Int
bList = (Cons 1 (Cons 1 (Cons 0 (Cons 0 (Cons 1 Nil))))) -- (11001)_BE2 = (19)_10

-- a
filterList :: (a -> Bool) -> List a -> List a
filterList _ Nil                       = Nil
filterList x (Cons l ls) | x l == True = Cons l (filterList x ls)
                         | otherwise   = filterList x ls

-- b
smallerThan :: Int -> List Int -> List Int
smallerThan n ls = filterList (\x -> x < n) ls

-- c
mapList :: (a -> b) -> List a -> List b
mapList _ Nil         = Nil
mapList f (Cons l ls) = Cons (f l) (mapList f ls)

-- d
setNegToZero :: List Int -> List Int
setNegToZero ls = mapList (\g -> if g < 0 then 0 else g) ls

-- e
foldList :: (a -> b -> b) -> b -> List a -> b
foldList _ c Nil          = c
foldList f c (Cons l ls)  = f l (foldList f c ls) 

-- f
prodList :: List Int -> Int
prodList ls = foldList (\x y -> x * y) 1 ls

-- g
binList :: List Int -> Int
binList (Cons l ls) = l + foldList (\r f -> r*2 + 2*f) 0 ls

