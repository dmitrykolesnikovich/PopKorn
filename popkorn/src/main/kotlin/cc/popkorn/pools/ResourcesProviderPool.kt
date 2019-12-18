@file:Suppress("UNCHECKED_CAST")
package cc.popkorn.pools

import cc.popkorn.providers.Provider
import cc.popkorn.core.exceptions.ProviderNotFoundException
import cc.popkorn.mapping.Mapping
import kotlin.reflect.KClass

/**
 * Implementation to get providers via resource mappings
 *
 * @author Pau Corbella
 * @since 1.3.0
 */
internal class ResourcesProviderPool(private val mappings:Set<Mapping>) : ProviderPool {

    override fun <T : Any> isPresent(clazz: KClass<T>) =  findProvider(clazz)!=null

    override fun <T : Any> create(clazz: KClass<T>): Provider<T> {
        return findProvider(clazz)
            ?.let { it as? Provider<T> }
            ?: throw ProviderNotFoundException(clazz)
    }

    private fun findProvider(original:KClass<*>) : Any?{
        mappings.forEach { map ->
            map.find(original)?.also { return it }
        }
        return null
    }

}