package com.robotoworks.mechanoid.net.generator;

import com.google.inject.Inject;
import com.robotoworks.mechanoid.net.generator.ImportHelper;
import com.robotoworks.mechanoid.net.generator.ModelExtensions;
import com.robotoworks.mechanoid.net.netModel.ComplexTypeDeclaration;
import com.robotoworks.mechanoid.net.netModel.ComplexTypeLiteral;
import com.robotoworks.mechanoid.net.netModel.GenericListType;
import com.robotoworks.mechanoid.net.netModel.Member;
import com.robotoworks.mechanoid.net.netModel.Model;
import com.robotoworks.mechanoid.net.netModel.SkipMember;
import com.robotoworks.mechanoid.net.netModel.Type;
import com.robotoworks.mechanoid.net.netModel.TypedMember;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EntityGenerator {
  @Inject
  private ImportHelper imports;
  
  public CharSequence generate(final ComplexTypeDeclaration type, final Model module) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = module.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence classDecl = this.generateType(type, module);
    _builder.newLineIfNotEmpty();
    StringConcatenation _printAndClear = this.imports.printAndClear();
    _builder.append(_printAndClear, "");
    _builder.newLineIfNotEmpty();
    _builder.append(classDecl, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateType(final ComplexTypeDeclaration type, final Model module) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    String _name = type.getName();
    _builder.append(_name, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    _builder.newLine();
    {
      ComplexTypeLiteral _literal = type.getLiteral();
      EList<Member> _members = _literal.getMembers();
      for(final Member member : _members) {
        _builder.append("        ");
        _builder.append("public static final String KEY_");
        String _name_1 = member.getName();
        String _upperCase = _name_1.toUpperCase();
        _builder.append(_upperCase, "        ");
        _builder.append(" = \"");
        String _name_2 = member.getName();
        _builder.append(_name_2, "        ");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    {
      ComplexTypeLiteral _literal_1 = type.getLiteral();
      EList<Member> _members_1 = _literal_1.getMembers();
      for(final Member member_1 : _members_1) {
        _builder.append("\t");
        CharSequence _generateField = this.generateField(member_1);
        _builder.append(_generateField, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    {
      ComplexTypeLiteral _literal_2 = type.getLiteral();
      EList<Member> _members_2 = _literal_2.getMembers();
      for(final Member member_2 : _members_2) {
        _builder.append("\t");
        CharSequence _generateGetterAndSetter = this.generateGetterAndSetter(member_2);
        _builder.append(_generateGetterAndSetter, "	");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateField(final TypedMember member) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private ");
    Type _type = member.getType();
    String _signature = ModelExtensions.signature(_type);
    _builder.append(_signature, "");
    _builder.append(" ");
    String _identifier = ModelExtensions.toIdentifier(member);
    _builder.append(_identifier, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    {
      Type _type_1 = member.getType();
      if ((_type_1 instanceof GenericListType)) {
        this.imports.addImport("java.util.List");
      }
    }
    _builder.append("\t");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _generateField(final SkipMember skipper) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ComplexTypeLiteral _literal = skipper.getLiteral();
      EList<Member> _members = _literal.getMembers();
      for(final Member member : _members) {
        Object _generateField = this.generateField(member);
        _builder.append(_generateField, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _generateGetterAndSetter(final TypedMember member) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public ");
    Type _type = member.getType();
    String _signature = ModelExtensions.signature(_type);
    _builder.append(_signature, "");
    _builder.append(" ");
    String _getMethodName = ModelExtensions.toGetMethodName(member);
    _builder.append(_getMethodName, "");
    _builder.append("(){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("return ");
    String _identifier = ModelExtensions.toIdentifier(member);
    _builder.append(_identifier, "	");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    _builder.append("public void ");
    String _setMethodName = ModelExtensions.toSetMethodName(member);
    _builder.append(_setMethodName, "");
    _builder.append("(");
    Type _type_1 = member.getType();
    String _signature_1 = ModelExtensions.signature(_type_1);
    _builder.append(_signature_1, "");
    _builder.append(" value){");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("this.");
    String _identifier_1 = ModelExtensions.toIdentifier(member);
    _builder.append(_identifier_1, "	");
    _builder.append(" = value;");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _generateGetterAndSetter(final SkipMember skipper) {
    StringConcatenation _builder = new StringConcatenation();
    {
      ComplexTypeLiteral _literal = skipper.getLiteral();
      EList<Member> _members = _literal.getMembers();
      for(final Member member : _members) {
        Object _generateGetterAndSetter = this.generateGetterAndSetter(member);
        _builder.append(_generateGetterAndSetter, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence generateField(final Member skipper) {
    if (skipper instanceof SkipMember) {
      return _generateField((SkipMember)skipper);
    } else if (skipper instanceof TypedMember) {
      return _generateField((TypedMember)skipper);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(skipper).toString());
    }
  }
  
  public CharSequence generateGetterAndSetter(final Member skipper) {
    if (skipper instanceof SkipMember) {
      return _generateGetterAndSetter((SkipMember)skipper);
    } else if (skipper instanceof TypedMember) {
      return _generateGetterAndSetter((TypedMember)skipper);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(skipper).toString());
    }
  }
}
