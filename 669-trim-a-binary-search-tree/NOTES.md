Recursive approach for almost all tree problems
base case: if root is null return null
3 possible cases can happen
case1: if **root.val > high** then according to BST property all elements to right of root will also be > high so we need to eliminate right half. hence return recursively **fn(root.left, low, high)**
case2: **else if(root.val<low)** then according to BST property all elements to the left of root will also be < low. so we  need to eliminate the left half. Hence return recursively **fn(root.right, low, high)**
case3: else root.val lies in range [low, high] so we need to further explore left subtree and right subtree recursively for nodes which can further have the above 3 cases
root.left = fn(root.left,..)
root.right = fn(root.right..)
​
Finally return root