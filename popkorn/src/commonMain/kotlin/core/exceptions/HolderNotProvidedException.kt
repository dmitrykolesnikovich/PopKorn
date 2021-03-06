package cc.popkorn.core.exceptions

import cc.popkorn.getName
import kotlin.reflect.KClass

class HolderNotProvidedException(clazz: KClass<*>) : RuntimeException("To inject ${clazz.getName()} you must provide a holder with inject() { holder(...) }")
