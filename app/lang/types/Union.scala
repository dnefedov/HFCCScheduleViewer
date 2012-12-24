package types

/**
 * Created with IntelliJ IDEA.
 * User: dnefedov
 * Date: 12/6/12
 * Time: 7:49 PM
 */
object Union {

  type ¬[A] = A => Nothing

  type ¬¬[A] = ¬[¬[A]]

  type ∨[T, U] = ¬[¬[T] with ¬[U]]

  type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }

  // Alias of the line above for better readability.
  type Or[T, U] = { type Type[X] = ¬¬[X] <:< (T ∨ U) }

}
