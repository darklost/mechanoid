package com.robotoworks.mechanoid.net.generator.strategy;

import com.robotoworks.mechanoid.net.generator.CodeGenerationContext;
import com.robotoworks.mechanoid.net.generator.strategy.MemberDeserializationStatementGenerator;
import com.robotoworks.mechanoid.net.netModel.ComplexTypeDeclaration;
import com.robotoworks.mechanoid.net.netModel.ComplexTypeLiteral;
import com.robotoworks.mechanoid.net.netModel.Member;
import com.robotoworks.mechanoid.net.netModel.Model;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class InputTransformerGenerator {
  private CodeGenerationContext context;
  
  public CodeGenerationContext setContext(final CodeGenerationContext context) {
    CodeGenerationContext _context = this.context = context;
    return _context;
  }
  
  public Object registerImports() {
    return null;
  }
  
  private MemberDeserializationStatementGenerator deserializationStatementGenerator;
  
  public MemberDeserializationStatementGenerator setMemberDeserializationStatementGenerator(final MemberDeserializationStatementGenerator deserializationStatementGenerator) {
    MemberDeserializationStatementGenerator _deserializationStatementGenerator = this.deserializationStatementGenerator = deserializationStatementGenerator;
    return _deserializationStatementGenerator;
  }
  
  public MemberDeserializationStatementGenerator getMemberDeserializationStatementGenerator() {
    return this.deserializationStatementGenerator;
  }
  
  public CharSequence generate(final ComplexTypeDeclaration decl, final Model module) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _packageName = module.getPackageName();
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence body = this.generateInputTransformerGeneratorClass(decl, module);
    _builder.newLineIfNotEmpty();
    Object _registerImports = this.registerImports();
    _builder.append(_registerImports, "");
    _builder.newLineIfNotEmpty();
    _builder.append("import com.robotoworks.mechanoid.net.Transformer;");
    _builder.newLine();
    _builder.append("import com.robotoworks.mechanoid.net.TransformException;");
    _builder.newLine();
    StringConcatenation _printImports = this.context.printImports();
    _builder.append(_printImports, "");
    _builder.newLineIfNotEmpty();
    this.context.clearImports();
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append(body, "");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateInputTransformerGeneratorClass(final ComplexTypeDeclaration decl, final Model module) {
    StringConcatenation _builder = new StringConcatenation();
    this.context.registerImport("org.json.JSONException");
    _builder.newLineIfNotEmpty();
    _builder.append("public class ");
    String _name = decl.getName();
    _builder.append(_name, "");
    _builder.append("InputTransformer extends Transformer<JSONObject, ");
    String _name_1 = decl.getName();
    _builder.append(_name_1, "");
    _builder.append("> {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void transform(JSONObject source, ");
    String _name_2 = decl.getName();
    _builder.append(_name_2, "	");
    _builder.append(" target) throws TransformException {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    {
      ComplexTypeLiteral _literal = decl.getLiteral();
      EList<Member> _members = _literal.getMembers();
      for(final Member member : _members) {
        _builder.append("\t\t\t");
        CharSequence _generate = this.deserializationStatementGenerator.generate(member, "provider", "source", "target", false);
        _builder.append(_generate, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("} catch (JSONException x) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("throw new TransformException(x);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
