% a
userDefinedList(nil).
userDefinedList(cons(_,XS)) :- userDefinedList(XS).

% b
/* cons(1, cons(2, cons(3, nil))) should be [1,2,3] */
isEqual(A,A).
isEqual(cons(A,nil),[A]).
isEqual(cons(A,AS), [A|BS]) :- isEqual(AS, BS).

asPrologList(X,Y) :- isEqual(X,Y). 

% c
append([],Y,Y).
append(X,[],X).
append([X|XS], Y, [X|Z]) :- append(XS, Y, Z).

% d
/* flatten([[1,2,3],[],[3,4]], [1,2,3,3,4]). evaluates true */
flatten([X],X).
flatten([[]|XS], LREST) :- flatten(XS, LREST).
flatten([[X|XS]|REST],[X|LREST]) :- flatten([XS|REST], LREST).

% e
/* MultiBranchTree mTree:
*  This tree contains nodes 'node' and leaves 'leaf'.
*  Branches can be either leaves or nodes.
*  Empty trees are represented by [].
*
*  Nodes own:
*   - a list of values: VAL
*   - a list of branches: BRANCHES
*  Leaves own:
*   - a list of values: VAL
*
*/
mTree([]).
mTree(leaf(_)).
mTree(node(_, BRANCHES)) :- mTree(BRANCHES).
mTree([HEAD|TAIL])       :- mTree(HEAD), mTree(TAIL). % list of BRANCHES will be prooved iff syntax is correct

% f
/* flattenTree(X, [1,2,3,15,7,3,7,15,11,12]). should be true where X is MultiBranchTree 
*
*    'node([1,2,3], [node([], [leaf([15]), leaf([7,3])]), leaf([]), node([7,15], [leaf([11,12])])])'
*  with the notation above.
*
*
*  flattenTree(node([1,2,3], [node([], [leaf([15]), leaf([7,3])]), leaf([]), node([7,15], [leaf([11,12])])]), X).
*
*  yields: X = [1,2,3,15,7,3,7,15,11,12]
*
*/
% common cases
flattenTree(leaf(VAL), VAL).
flattenTree(leaf([X|VT]), [X|LT])                     :- flattenTree(leaf(VT), LT).
flattenTree(node(VAL, []), VAL).
flattenTree(node([X|VT], BRANCHES), [X|LT])           :- flattenTree(node(VT, BRANCHES), LT).

% node-leaf cases
flattenTree(node([], [leaf([])|BT]), LIST)            :- flattenTree(node([], BT), LIST).
flattenTree(node([], [leaf([X|VT])|BT]), [X|LT])      :- flattenTree(node([], [leaf(VT)|BT]), LT).

% node-node cases
flattenTree(node([], [node(VAL, BRANCHES)|BT]), LIST) :- append(BRANCHES, BT, RES),
                                                         flattenTree(node(VAL, RES), LIST).

