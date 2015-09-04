import Text.Show.Functions -- Ability to print example on screen.
-- a
data BinTree a b = Leaf b | Node a (BinTree a b) (BinTree a b) deriving Show

example :: BinTree (Int -> Bool) Char
example = Node (\x -> x > 4) (Node (\x -> x * x == x) (Leaf 'g') (Node (\x -> x == 0) (Leaf 'i') (Leaf 'l'))) (Node (\x -> x >= 7) (Leaf 'f') (Leaf 'u'))

-- b
countLeaves :: BinTree a b -> Int
countLeaves (Leaf _)     = 1
countLeaves (Node _ l r) = (countLeaves l) + (countLeaves r)

-- c 
decodeInt :: BinTree (Int -> Bool) b -> Int -> b
decodeInt (Leaf c) _     = c
decodeInt (Node v l r) x = if (v x) then (decodeInt r x) else (decodeInt l x)

-- d
decode :: BinTree (Int -> Bool) b -> [Int] -> [b]
decode bt xs = map (decodeInt bt) xs 

-- e
mapTree :: (b -> c) -> BinTree a b -> BinTree a c
mapTree f (Leaf k) = Leaf (f k)
mapTree f (Node v l r) = Node v (mapTree f l) (mapTree f r) 
