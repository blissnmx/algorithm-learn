/**
 * @author ning_mx
 * @date 14:30 2022/2/28
 * @desc
 */
package hash;

import java.util.*;

/**
 * @author ning_mx
 * @date 2022/2/28
 * 设计一个数据结构，使得如下三个操作的时间复杂度都是O(1)：
 *
 * + insert(value)：如果数据集不包含一个数值，则把它添加到数据集；
 * + remove(value)：如果数据集包含一个数值，则把它删除；
 * + getRandom()：随机返回数据集中的一个数值，要求数据集里每个数字被返回的概率都相同
 */
public class SpecialStructure<T> {
    private Map<T,Integer> mapContainer ;
    private List<T> listContainer ;
    /**
     * hash表满足instet、remove时间复杂度O(1)
     * list（动态数组）满足getRandom方法返回元素的概率相同
     */
    public SpecialStructure() {
        mapContainer = new HashMap();
        listContainer = new ArrayList();
    }

    public void insert(T val){
        if(mapContainer.containsKey(val)){
            return ;
        }
        //key为元素，value为列表的下标
        mapContainer.put(val, listContainer.size());
        listContainer.add(val);
    }

    public boolean remove(T val){
        if (!mapContainer.containsKey(val)) {
            return false;
        }
        Integer index = mapContainer.get(val);
        mapContainer.remove(val);
        //用最后一个元素覆盖当前元素，然后删除最后一个元素，避免列表迁移（动态数组删除后为了避免内存浪费，后面的元素要移动位置）
        listContainer.set(index, listContainer.get(listContainer.size() - 1));
        listContainer.remove(listContainer.size() - 1);
        return true ;
    }

    public T getRandom(){
        Random rd = new Random(listContainer.size() - 1);
        return  listContainer.get(rd.nextInt());
    }
}
