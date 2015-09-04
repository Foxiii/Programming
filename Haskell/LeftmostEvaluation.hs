{-
== :: a -> a -> Bool
+ :: Int -> Int -> Int
head :: [a] -> a

Anmerkung:
Der Listenkonstruktor : impliziert eine Liste gleichen Typs. Dementsprechend ist das vorangestellte Kopfelement vom Typ der Liste.
-}

-- i)
f xs y [] = []
f (x:xs) y (z:zs) = if z then ((x + y) : f xs y zs) else (x : f xs y zs)

{- Auswertung
x :: Int
y :: Int
  x und y sind vom Typ Int, welches aus dem Pattern der Definition folgt: + :: Int -> Int -> Int.
xs :: [Int]
  x ist vom Typ Int und Kopf von xs. Wegen Typkorrektheit ist xs vom Typ [Int].
z :: Bool
zs :: [Bool]
  z wird in der if-Abfrage evaluiert, muss also Bool zurückgeben. z ist Kopf der Liste z:zs; wegen Typkorrektheit muss zs vom Typ [Bool] sein.

Insgesamt ergibt sich daraus:
f :: [Int] -> Int -> [Bool] -> [Int]
-}


-- ii)
g x y = g (head y) y
g x y = (\x -> x) y

{- Auswertung
y :: [a]
  Aus der Definition folgt, dass head von [a] nach a abbildet. Folglich ist y vom Typ [a]
x :: a
  Nach Pattern-Matching folgt x :: a. (head y) steht im Pattern an der Stelle von x. Darüber hinaus bildet x mittels Inline-Funktion auf sich selbst ab.

Insgesamt folgt:
g :: a -> [a] -> a [a]
  Eine speziellere Verallgemeinerung ist nicht möglich.
-}


-- iii)
h w x [] z     = if w == [] then head z else h w x [] z
h w x (y:ys) z = if w == [x] then y else (x + 1, x)

{- Auswertung
x :: Int
  Die Operation + ist auf Int-Werte definiert (siehe oben). Woraus folgt, dass x vom Typ Int ist.
w :: [Int]
  == bildet a -> a -> Bool ab. Da x vom Typ Int, [x] folglich vom Typ [Int] ist, ist w vom Typ [Int].
y :: (Int,Int)
  Nach Rückgabewert "else (x + 1, x)" ergibt sich y ist Dupel von Int.
ys :: [(Int,Int)]
  Da y vom Typ (Int,Int) und Kopf der Liste y:ys ist, folgt aus der Typkorrektheit: ys :: [(Int,Int)].
z :: [(Int,Int)]
  head bildet [a] -> a ab. Wegen des Rückgabetypes (Int,Int) ist z vom Typ [(Int,Int)].

Insgesamt folgt:
h :: [Int] -> Int -> [(Int,Int)]-> [(Int,Int)] -> (Int,Int) 
-}


-- iv)
data X a b = A a | B Int | F (a -> b -> Bool)

i (F f) x y = f x y
i _ x y     = i h x y
  where
    h = A (B y)

{- Auswertung

h :: X(X a b) Int
  Dies geht aus dem where Zweig hervor. Hier wird der Konstruktor A a zunächst verwendet vom Typ X a b. Allerdings wird im geklammerten Ausdruck (B y)
  ein weiterer Konstruktor aufgerufen. Also zunächst "A B Int". Da es hier um zwei Konstruktoren vom Typ X handelt muss es wie folgt aussehen:
  X(X a b) Int. Da aber der innere Wert von A(B y) einen B Konstruktor aufruft, ist klar das y Int sein muss.
y :: Int
  In der Lokaldeklaration (where Zweig) von h wird y mit dem Konstruktor B aufgerufen. Dieser besitzt das Argument vom Typ Int. 
  Da y aus der Funktionsdeklaration verwendet wird, ist y vom Typ Int.
x :: X a b
  Wegen Pattern-Matchings und h anstelle von x, muss x vom Typ X a b sein.
f :: a -> b -> Bool
  Dies folgt aus dem Konstruktor für F(a -> b -> Bool) X a b. Bzw aus der Anwendung von f auf x y. Da die Funktion f x -> y -> Bool abbildet muss der Rückgabewert
  der Funktion i Bool sein.

Insgesamt folgt:
i :: X (X a b) Int -> X a b -> Int -> Bool
-}
