-- a
factorial :: Int -> Int
factorial 0 = 1
factorial x = x * factorial (x-1)

-- b
digitSum :: Int -> Int
digitSum 0 = 0
digitSum x = (digitSum (div x 10)) + (mod x 10)

-- c
onlyEven :: [Int] -> [Int]
onlyEven [] = []
-- onlyEven (x:xs) = if (mod x 2) == 0 then x : onlyEven xs else onlyEven rest
onlyEven (x:xs) | (mod x 2) == 0 = x : onlyEven xs
                | otherwise      = onlyEven xs

-- d
reverses :: [Int] -> [[Int]]
reverses []     = []
reverses (list) = toList (invert list)
  where
    invert :: [Int] -> [Int]
    invert [element]      = [element]
    invert (element:rest) = (invert rest) ++ [element]
--
    toList :: [Int] -> [[Int]]
    toList [element]      = [[element]]
    toList (element:rest) = (toList rest) ++ [element:rest] 

-- e
permutations :: [Int] -> [[Int]]
permutations []       = [[]]
permutations (x:[])   = [[x]]
permutations (x:y:[]) = [[x,y],[y,x]]
permutations (x:xs)   = insertValueIntoList x (permutations xs)
  where insertValueIntoList :: Int -> [[Int]] -> [[Int]]
        insertValueIntoList v []     = []
        insertValueIntoList v (y:ys) = (insertAll v y (lLength y)) ++ (insertValueIntoList v ys)

        insertAll :: Int -> [Int] -> Int -> [[Int]]
        insertAll v [] _   = [[v]]
        insertAll v xs 0   = [insert v xs 0]
        insertAll v (xs) n = (insertAll v xs (n - 1)) ++ [insert v xs n]

        lLength :: [Int] -> Int
        lLength []     = 0
        lLength (x:xs) = 1 + lLength xs

        insert :: Int -> [Int] -> Int -> [Int]
        insert b [] n     = [b]
        insert b (y:ys) 0 = (b:(y:ys))
        insert b (y:ys) n = (y:(insert b ys (n-1)))

-- f
anagram :: [Int] -> [Int] -> Bool
anagram	[] []   = True
anagram [a] [b] = (a == b)
anagram (x:xs) ys	|	((lLength (x:xs)) /= (lLength ys)) = False
					        |	otherwise                          = und (lSearch x ys) (anagram xs (lRemove x ys))
	where 
		lSearch :: Int -> [Int] -> Bool
		lSearch _ []     = False
		lSearch x (y:[]) = (x == y)
		lSearch x (y:ys) | (x == y)  = True
        						 | otherwise = lSearch x ys
		
		und :: Bool -> Bool -> Bool
		und True y  = y
		und False y = False
		
		lRemove :: Int -> [Int] -> [Int]
		lRemove x [] = []
		lRemove x (y:ys) | (x == y)  = ys
						         | otherwise = y:(lRemove x ys)
		
		lLength :: [Int] -> Int
		lLength []     = 0
		lLength (x:xs) = 1 + (lLength xs)

