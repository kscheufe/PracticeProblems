#include <cstdlib>
#include <vector>
#include <unordered_map>

class RandomizedSet {
private:
    std::unordered_map<int, int> map;
    std::vector<int> elements;

public:
    RandomizedSet() {
    }
    
    bool insert(int val) {
        if (map.find(val) != map.end())//val already exists in map
        {return false;}
        map[val] = elements.size();
        elements.push_back(val);
        return true;
    }
    
    bool remove(int val) {
        if (map.find(val) == map.end()) //value doesn't exist
        {return false;}
        int lastElement = elements.back();
        int idx = map[val];
        elements[idx] = lastElement;//move the last element to the pos of the element to be removed
        map[lastElement] = idx;//update the map for latest element
        elements.pop_back();//remove last element
        map.erase(val);//remove the element from the map
        return true;
    }
    
    int getRandom() {
        if (elements.empty()) {
            throw std::out_of_range("no elements in this set");
        }
        int randomIndex = rand() % elements.size();//generate random index modulo size of map
        return elements[randomIndex];//return the element at the random index
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */