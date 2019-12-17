package cc.popkorn.instances

import cc.popkorn.exceptions.InstanceNotFoundException

/**
 * Instances implementation for manually scoped instances
 * Calling get() will return a previously added T::class. If not added or already removed,
 * will throw a RuntimeException
 *
 * @author Pau Corbella
 * @since 1.0.0
 */
internal class RuntimeInstances<T:Any>: Instances<T> {
    private val instances = HashMap<String?, T>()

    override fun get(environment:String?) : T{
        return instances[environment] ?: instances[null] ?: throw InstanceNotFoundException()
    }

    fun put(environment:String?, data:T) = instances.put(environment, data)

    fun remove(environment:String?){
        instances.remove(environment)
    }

    override fun size() = instances.size

}