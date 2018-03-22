package hr.hrg.hipster.dao.test;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import hr.hrg.hipster.dao.IUpdatable;
import hr.hrg.hipster.dao.jackson.DirectSerializer;
import hr.hrg.hipster.dao.jackson.IDirectSerializerReady;
import hr.hrg.hipster.sql.BaseColumnMeta;

import java.io.IOException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;

@JsonSerialize(
    using = DirectSerializer.class
)
public class User1Update implements User1, IUpdatable<BaseColumnMeta<?>>, IDirectSerializerReady {
  protected long _changeSet;

  protected Long id;

  protected List<String> name;

  protected int age;

  User1Update() {
  }

  @JsonCreator
  public User1Update(@JsonProperty("id") Long id, @JsonProperty("name") List<String> name,
      @JsonProperty("age") int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public User1Update(User1 v) {
    if(v == null) return;
    this.id = v.getId();
    this.name = v.getName();
    this.age = v.getAge();
  }

  public Long getId() {
    return id;
  }

  public User1Update id(Long id) {
    this._changeSet |= 1L;
    this.id = id;
    return this;
  }

  public List<String> getName() {
    return name;
  }

  public User1Update name(List<String> name) {
    this._changeSet |= 2L;
    this.name = name;
    return this;
  }

  public int getAge() {
    return age;
  }

  public User1Update age(int age) {
    this._changeSet |= 4L;
    this.age = age;
    return this;
  }

  @Override
  public void setValue(BaseColumnMeta<?> column, Object value) {
    this.setValue(column.ordinal(), value);
  }

  @Override
  public final Object getValue(BaseColumnMeta<?> column) {
    return this.getValue(column.ordinal());
  }

  @Override
  public final Object getValue(int ordinal) {
    switch (ordinal) {
    case 0: return this.id;
    case 1: return this.name;
    case 2: return this.age;
    default: throw new ArrayIndexOutOfBoundsException(ordinal);
    }
  }

  public void serialize(JsonGenerator jgen, SerializerProvider provider) throws IOException,
      JsonGenerationException {
    jgen.writeStartObject();

    jgen.writeFieldName("id");
    if (id == null)
    	jgen.writeNull();
    else
    	jgen.writeNumber(id);

    jgen.writeFieldName("name");
    if (name == null)
    	jgen.writeNull();
    else
    	jgen.writeObject(name);

    jgen.writeFieldName("age");
    jgen.writeNumber(age);

    jgen.writeEndObject();
  }

  @Override
  public void setValue(int ordinal, Object value) {
    switch (ordinal) {
    case 0: this.id = (Long) value;break;
    case 1: this.name = (List<String>) value;break;
    case 2: this.age = (Integer) value;break;
    default: throw new ArrayIndexOutOfBoundsException(ordinal);
    }
    this._changeSet |= (1L<<ordinal);
  }

  @Override
  public boolean isEmpty() {
    return _changeSet == 0;
  }

  @Override
  public boolean isChanged(BaseColumnMeta<?> column) {
    return (_changeSet & (1L << column.ordinal())) != 0;
  }

  @Override
  public boolean isChanged(int ordinal) {
    return (_changeSet & (1L << ordinal)) != 0;
  }
}
