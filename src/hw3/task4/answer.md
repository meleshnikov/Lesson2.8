### Вопрос:

Какой из этих коллекций понадобится меньше времени на выполнение данного метода при большом наборе данных?
Почему?

* ArrayList.
* LinkedList.
* HashSet.

### Ответ:
Меньше всего времени понадобится коллекции HashSet.
Метод containsAll() реализован в классе AbstractCollection

``` java
public boolean containsAll(Collection<?> c) {
    for (Object e : c)
        if (!contains(e))
            return false;
        return true;
    }
```

В цикле пробегаем по каждому элементу коллекции и вызываем метод contains().
Метод contains() переопределен в HashSet , ArrayList и др.

#### Реализация метода contains() в классе HashSet

``` java
public boolean contains(Object o) {
    return map.containsKey(o);
}
```

containsKey() реализован в классе HashMap

``` java
public boolean containsKey(Object key) {
    return getNode(hash(key), key) != null;
}

final Node<K,V> getNode(int hash, Object key) {
    Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
    if ((tab = table) != null && (n = tab.length) > 0 &&
        (first = tab[(n - 1) & hash]) != null) {
        if (first.hash == hash && // always check first node
            ((k = first.key) == key || (key != null && key.equals(k))))
            return first;
        if ((e = first.next) != null) {
            if (first instanceof TreeNode)
                return ((TreeNode<K,V>)first).getTreeNode(hash, key);
            do {
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    return e;
            } while ((e = e.next) != null);
        }
    }
    return null;
}
```

#### Реализация метода contains() в классе ArrayList

``` java
public boolean contains(Object o) {
    return indexOf(o) >= 0;
}

public int indexOf(Object o) {
    return indexOfRange(o, 0, size);
}

int indexOfRange(Object o, int start, int end) {
    Object[] es = elementData;
    if (o == null) {
        for (int i = start; i < end; i++) {
            if (es[i] == null) {
                return i;
            }
        }
    } else {
        for (int i = start; i < end; i++) {
            if (o.equals(es[i])) {
                return i;
            }
        }
    }
    return -1;
}
```

Получается, что в HashSet объекты сравниваются по хеш-коду.
А в ArrayList объекты сравниваются при помощи метода equals.



