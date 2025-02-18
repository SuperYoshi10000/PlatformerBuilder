/**
 * <h2 id="">Data Tags</h1>
 *
 * Provides classes for representing and manipulating data tags.
 *
 * <p>
 * Tags are used to store data in a structured format, similar to JSON or XML.
 * Each tag has a type and a value. Tags can also be nested within some other tags,
 * like {@link local.ytk.g.platformer1.data.tag.CompoundTag}s or {@link local.ytk.g.platformer1.data.tag.ListTag}s.
 * </p>
 *
 * <div>
 * Structure:
 * <ul>
 *     <li>{@link local.ytk.g.platformer1.data.tag.TagRepresentable} - Interface for objects that can be converted to tags, including tags themselves
 *     <li>{@link local.ytk.g.platformer1.data.tag.Tag} - Base interface for all tags
 *     <ul>
 *         <li>{@link local.ytk.g.platformer1.data.tag.NumericTag} - Tags that store numeric values
 *         <ul>
 *             <li>{@link local.ytk.g.platformer1.data.tag.ByteTag} - Tags that store byte values, as well as boolean values or ascii characters
 *             <li>{@link local.ytk.g.platformer1.data.tag.ShortTag} - Tags that store short values, as well as character values
 *             <li>{@link local.ytk.g.platformer1.data.tag.IntTag} - Tags that store int values, as well as color values or unicode characters
 *             <li>{@link local.ytk.g.platformer1.data.tag.LongTag} - Tags that store long values, as well as time values or unique identifiers
 *             <li>{@link local.ytk.g.platformer1.data.tag.FloatTag} - Tags that store float values
 *             <li>{@link local.ytk.g.platformer1.data.tag.DoubleTag} - Tags that store double values
 *         </ul>
 *         <li>{@link local.ytk.g.platformer1.data.tag.ObjectTag} - Tags that can contain multiple values
 *         <ul>
 *             <li>{@link local.ytk.g.platformer1.data.tag.MapTag} - Tags that store key-value pairs of tags
 *             <ul>
 *                 <li>{@link local.ytk.g.platformer1.data.tag.CompoundTag} - Tags that store a map of tags with any type
 *                 <li>{@link local.ytk.g.platformer1.data.tag.TypedMapTag} - Tags that store a map of tags with a specific type
 *             </ul>
 *             <li>{@link local.ytk.g.platformer1.data.tag.SequenceTag} - Tags that store a sequence of values
 *             <ul>
 *                 <li>{@link local.ytk.g.platformer1.data.tag.AbstractArrayTag} - Base class for sequence tags
 *                 <ul>
 *                     <li>{@link local.ytk.g.platformer1.data.tag.AbstractListTag} - Tags that store a sequence of tags
 *                     <ul>
 *                         <li>{@link local.ytk.g.platformer1.data.tag.ListTag} - Tags that store a list of tags with any type
 *                         <li>{@link local.ytk.g.platformer1.data.tag.TypedListTag} - Tags that store a list of tags with a specific type
 *                         <ul>
 *                             <li>{@link local.ytk.g.platformer1.data.tag.CompoundListTag} - Tags that store a list of compound tags
 *                             <li>{@link local.ytk.g.platformer1.data.tag.ListListTag} - Tags that store a list of list tags
 *                         </ul>
 *                     </ul>
 *                     <li>{@link local.ytk.g.platformer1.data.tag.NumericArrayTag} - Tags that store a sequence of numeric values
 *                     <ul>
 *                         <li>{@link local.ytk.g.platformer1.data.tag.ByteArrayTag} - Tags that store a sequence of byte values, as well as raw binary data
 *                         <li>{@link local.ytk.g.platformer1.data.tag.ShortArrayTag} - Tags that store a sequence of short values
 *                         <li>{@link local.ytk.g.platformer1.data.tag.IntArrayTag} - Tags that store a sequence of int values, as well as vectors
 *                         <li>{@link local.ytk.g.platformer1.data.tag.LongArrayTag} - Tags that store a sequence of long values, as well as vectors or multiple identifiers
 *                         <li>{@link local.ytk.g.platformer1.data.tag.FloatArrayTag} - Tags that store a sequence of float values
 *                         <li>{@link local.ytk.g.platformer1.data.tag.DoubleArrayTag} - Tags that store a sequence of double values, as well as vectors
 *                     </ul>
 *                     <li>{@link local.ytk.g.platformer1.data.tag.StringArrayTag} - Tags that store a sequence of string values
 *                 </ul>
 *                 <li>{@link local.ytk.g.platformer1.data.tag.RepeatedTag} - Tags that store a single value repeated multiple times
 *             </ul>
 *         </ul>
 *         <li>{@link local.ytk.g.platformer1.data.tag.StringTag} - Tags that store string values
 *     </ul>
 * </ul>
 */

package local.ytk.g.platformer1.data.tag;
