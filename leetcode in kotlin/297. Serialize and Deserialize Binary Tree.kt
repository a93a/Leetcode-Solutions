/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

//using stringbuilder and index pointer, seems to be faster and use less memory
// not so sure about the pointer/list variation though
class Codec() {

    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        preOrder(root, sb)
        return sb.toString()
    }
    
    private fun preOrder(node: TreeNode?, sb: StringBuilder){
        if(node == null){
            sb.append("n,")
        }else{
            sb.append(node.`val`)
            sb.append(",")
            preOrder(node.left, sb)
            preOrder(node.right, sb)
        }
    }

    private var pos = 0
    fun deserialize(data: String): TreeNode? {
        val nodes = data.split(",")
        pos = 0
        return preOrder(nodes)
    }
    
    private fun preOrder(nodes: List<String>): TreeNode? {
        val value = nodes[pos++]
        if(value == "n")
            return null
        val parent = TreeNode(value.toInt())
        parent.left = preOrder(nodes)
        parent.right = preOrder(nodes)
        return parent
    }

}


// without stringbuilder
class Codec() {

    fun serialize(root: TreeNode?): String {
        root?: return ""
        val seri = preOrder(root)
        return seri
    }
    
    private fun preOrder(root: TreeNode?): String {
        root?: return "n"
        var res = ""
        res += root.`val`.toString()+","
        res += preOrder(root.left)+","
        res += preOrder(root.right)
        return res
    }

    fun deserialize(data: String): TreeNode? {
        if(data == "")
            return null
        val values = data.split(",")
        val list = ArrayList<String>()
        list.addAll(values)
        return preOrder(list)
    }
    
    private fun preOrder(list: ArrayList<String>): TreeNode? {
        val value = list.removeAt(0)
        if(value == "n")
            return null
        val parent = TreeNode(value.toInt())
        parent.left = preOrder(list)
        parent.right = preOrder(list)
        return parent
    }


/**
 * Your Codec object will be instantiated and called as such:
 * var ser = Codec()
 * var deser = Codec()
 * var data = ser.serialize(longUrl)
 * var ans = deser.deserialize(data)
 */
