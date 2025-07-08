# Aufgaben (Binärer Suchbaum)

Diese Aufgaben basieren auf einer abgewandelten Musterlösung der Präsenzübung 07.
Es ist empfehlenswert sich mit den Inhalten der Präsenzübung vertraut zu machen, dies ist jedoch nicht notwendig.

## a) Löschen eines Wertes
Implementieren Sie die Methode `TreeNode<T> delete(TreeNode<T> root, T value)`.
Diese Methode entfernt einen Knoten mit dem gegebenen Wert `value` aus dem binären Suchbaum.
Der Baum bleibt dabei weiterhin gültig gemäß den Regeln eines binären Suchbaums.
Die Methode gibt die neue Wurzel des Teilbaums zurück, nachdem die Löschoperation durchgeführt wurde.

Falls der Baum leer ist or der `value` nicht vorhanden ist im Baum, soll die Methode einfach den Eingabebaum unverändert wieder ausgeben.

Ihre Methode muss die folgende Signatur (Namen der  Methode, Ausgabetyp und Liste an Eingabetypen) haben:

```
    /**
     * The method delete searches root for the given value, and if present
     * deletes it from the tree, returning a binary search tree with all
     * the same values as the input tree, except for the input value.
     * If the tree is empty or the value is not present in the tree,
     * this method simply returns the input tree.
     *
     *
     * @param root	The three on which the delete is performed.
     * @param value The value to delete from root.
     * @return      The output tree after deletion.
     */
    public TreeNode<T> delete(TreeNode<T> root, T value)
```


## b) Search - Range
Implementieren Sie die Methoden `List<T> searchRange(TreeNode<T> node, T min, T max)`.
Diese Methode soll alle Knotenwerte ermitteln, deren Werte im geschlossenen Intervall [`min`,`max`] liegen.
Die Rückgabe soll eine Liste aller passenden Werte in beliebiger Reihenfolge enthalten.
Falls der Eingabebaum leer ist, soll die leere Liste zurückgegeben werden.


Beispiel: `searchRange(root, 10, 30)` gibt die Liste `[10,15,20,30]` zurück.


Verwenden Sie die folgende Signatur:

```
    /**
     * searchRange gets a tree root and two values, min and max,
     * as input. It will produce a list of all values in root
     * which are in between (w.r.t. the comparator of the binary
     * search tree) of min and max. Both ends are inclusive, so
     * values that are equal to min or equal to max are to be
     * included.
     * In case of an empty tree, the empty list should be returned.
     *
     * @param node The input tree that will be searched.
     * @param min  The lower end of the range of values to be returned (inclusive).
     * @param max  The upper end of the range of values to be returned (inclusive).
     * @return A list of values in node which are in between the values of min and max
     * or equal to min or equal to max.
     */
     public List<T> searchRange(TreeNode<T> node, T min, T max)
```

## c) Max - Min
Implementieren Sie die Methoden `T Max_Min(TreeNode<T> root, boolean isMin)`.
Diese Methode gibt entweder das Minimum oder das Maximum des binären Suchbaums zurück – je nachdem, welchen Wert die übergebene Variable `isMin` hat.
Ist `isMin == true`, wird der kleinste Wert im Baum zurückgegeben.
Ist `isMin == false`, wird der größte Wert im Baum zurückgegeben.

Falls der Eingabebaum leer ist, soll null zurückgegeben werden.

Verwenden Sie die folgende Signatur:

```
    /**
     * Max_Min will return either the minimal value among the
     * values of root, if the second argument isMin is set to true.
     * If the second argument is set to false, it will return the
     * maximal value instead.
     * In case of an empty tree, it should simply return null.
     *
     * @param root	The tree to be searched.
     * @param isMin Indicates the type of search: true means searching
     * for the smallest value in root, false means searching for the
     * highest value in root.
     * @return A value in root, either the smallest or highest value,
     * based on the value of isMin or null in case root is empty.
     */
     public T Max_Min(TreeNode<T> root, boolean isMin)
```

## d) Kombinieren von 2 BSTs
Implementieren Sie die Methode `TreeNode<T> combineBSTs(TreeNode<T> root1, TreeNode<T> root2)`.
Die Methode soll zwei bestehende binäre Suchbäume (BSTs) zu einem einzigen gültigen BST kombinieren.
Dabei werden alle Knoten aus dem zweiten Baum mit Wurzel `root2` schrittweise in den ersten Baum mit Wurzel `root1` eingefügt.
Die Struktur des resultierenden Baums muss die Eigenschaften eines binären Suchbaums erfüllen, muss jedoch nicht balanciert sein.

Falls sowohl `root1` als auch `root2` leer sind, soll ein leerer Baum zurückgegeben werden. Falls nur einer von beiden leer ist, soll der jeweils andere zurückgeben werden.

```
    /**
     * CombineBST takes as input two binary search trees, root1 and root2
     * and produces a new binary search tree that contains all values
     * in root1 or root2. In case both trees are empty, this must return
     * the empty tree. If only one is empty, it must return the other,
     * non-empty tree.
     *
     * @param root1  The first of the two trees to be combined.
     * @param root2  The second of the two trees to be combined.
     * @return A new tree, with all values of root1 and root2 or the empty
     * tree in case both root1 and root2 are empty.
     */
    public TreeNode<T> combineBSTs(TreeNode<T> root1, TreeNode<T> root2)
```

# Aufgaben (AVL Baum)

Dieser Teil des Miniprojektes erweitert die Datenstruktur des AVL Baums, wie sie in der Präsenzübung 8 behandelt wurde.
Im im package `datastructures` innerhalb des `src`-Verzeichnisses finden sie die Klasse `AVLTree.java`, welche eine Basisimplementierung von Übung 8 beinhaltet und als Startpunkt für Ihre Lösung dient.

## a) Löschen eines Wertes

Implementieren Sie eine Methode um einen Wert aus dem AVL Baum zu löschen.
Stellen Sie sicher, dass der Baum nach dem Löschen immer noch ein korrekter AVL Baum ist - insbesondere, dass die Balanciertheit immer noch gilt.

Falls der zu löschende Wert nicht im Baum vorkommt oder der Baum leer ist, soll einfach der Eingabebaum ausgegeben werden, ohne Änderungen durchzuführen.

Ihre Methode muss die folgende Signatur (Namen der  Methode, Ausgabetyp und Liste an Eingabetypen) haben:

```
    /**
     * The delete method checks whether a given AVL tree contains a
     * value, if so it will produce a new AVL tree without this value,
     * maintaining all properties of an AVL, in particular balancedness.
     * If value not present, it simply returns the original tree.
     *
     * @param root   the AVL Tree as input
     * @param value  the value to delete, if present. If not present, do nothing.
     * @return       the produced AVL Tree. Identical with input if value not present.
     */
public TreeNode<T> delete(TreeNode<T> root, T value)
```

## b) Durchschnitt und Median

Implementieren Sie zunächst eine Methode um den Durchschnitt über alle Werte des AVL Baums zu berechnen und als Wert vom Typ Double ausgibt.
Dies setzt voraus, dass der generische Typ `T` von `Number` erbt.

Falls der Baum keine Werte hat (also leer ist), soll `0.0` ausgegeben werden.

Ihre Lösung muss die folgende vorgegebene Signatur haben:

```
    /**
     * Search all values in the AVL Tree and compute the average value
     * of type Double of all those values. This requires that the values
     * in the AVL Tree extend the Number class.
     * In case of an empty tree, return 0.0.
     *
     *
     * @param <T>  The type of the values in the AVL Tree
     * @param node The root node of the AVL Tree
     * @return     The average value of all values in the AVL Tree, in Double
     */
public <T extends Number>Double findAVG(TreeNode<T> node)
```

Implementieren  Sie als zweiten Schritt auch  eine Methode um den Median zu berechnen und als Wert vom Typ Double auszugeben.
Falls der Baum keine Werte hat (also leer ist), soll 0.0 ausgegeben werden.
Verwenden Sie die folgende Signatur:


```
    /**
     * Search all values in the AVL Tree and compute the Median value
     * of type Double of all those values. This requires that the values
     * in the AVL Tree extend the Number class.
     * In case of an empty tree, return 0.0.
     *
     * @param <T>  The type of the values in the AVL Tree
     * @param node The root node of the AVL Tree
     * @return     The Median value of all values in the AVL Tree, in Double
     */
public <T extends Number>Double findMedian(TreeNode<T> node)
```

## c) 2 AVL Bäume vereinigen - "merge"

Implementieren Sie die folgende Methode. Als Eingabe bekommen Sie die AVL Bäume `tree1` und `tree2`.
Nehmen Sie an, dass jeder Wert in `tree1` kleiner ist als alle Werte in `tree2`.
In anderen Worten, es kann keinen Wert in `tree2` geben, der größer gleich irgendein Wert in `tree1` ist.
Die Ausgabe soll ein neuer AVL Baum sein, der alle Werte von `tree1` und `tree2` beinhaltet.

Hinweis: Falls beide Bäume leer sind, muss ein leerer Baum ausgegeben werden.
Falls nur einer der beiden Bäume leer ist, must der jeweils nicht-leere Baum ausgegeben werden.

Ihre Lösung muss die vorgegebene Signatur haben:

```
    /**
     * Merges two AVL trees into a single AVL tree.
     * Precondition: All elements in tree1 must be less than all elements in tree2.
     * This method is crucial for the split operation.
     * If both trees are empty, return the empty tree. In case only one is empty,
     * this returns the other non-empty tree.
     *
     *
     * @param tree1 The root of the first AVL tree.
     * @param tree2 The root of the second AVL tree.
     * @return The root of the merged AVL tree.
     */
public TreeNode<T> merge(TreeNode<T> tree1, TreeNode<T> tree2)
```

## d) In 2 neue AVL Bäume Teilen - "split"

Implementieren Sie die folgende Methode.
Als Eingabe bekommen sie einen AVL Baum (der  "Eingabebaum") und einen Wert `value` vom Typ `T`.
Die Ausgabe soll eine Liste von 2 AVL Bäumen sein.
Der erste Baum soll alle Werte des Eingabebaums beinhalten, die kleiner sind als `value`.
Der zweite Baum soll alle Werte des Eingabebaums beinhalten, die größer sind als `value`.

Hinweis: Der Wert von `value` selbst soll in keinem der beiden Ausgabebäume vorkommen.
Falls `value` kleiner ist als alle Werte im Eingabebaum, dann muss der erste Baum in der Ausgabe leer sein und der zweite Baum identisch zum Eingabebaum.
Analog, falls `value` größer ist als alle Werte im Eingabebaum.


Ihre Lösung muss die vorgegebene Signatur haben:

```
    /**
     * Splits an AVL tree into two subtrees based on a given value.
     * If the input tree is empty, return a list containing two empty trees.
     * If value is higher than all values in root, then the first tree return must be identical to root and the second tree
     * must be empty. Vice-versa, if value is lower than all values in root, then the first
     * tree in the output must be empty, and the second must be identical to the input.
     *
     * @param root The root of the current AVL tree.
     * @param value The value to split the tree by.
     * @return An array of two TreeNodes: result[0] is the root of the tree with elements less than 'value',
     * and result[1] is the root of the tree with elements greater than 'value'.
     * If 'value' exists in the tree, it is NOT included in either subtree.
     */
public TreeNode<T>[] split(TreeNode<T> root, T value)
```
