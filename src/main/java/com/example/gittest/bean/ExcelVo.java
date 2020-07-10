package com.example.gittest.bean;

public class ExcelVo {
    String name = null;//列名
    boolean needMerge = false;//	纵向合并单元格
    String orderNum = "0";//列的排序,支持name_id
    String[] replace = {};//值得替换 导出是{a_id,b_id} 导入反过来
    String savePath = "D:\\";//	导入文件保存路径
    int type = 1;//	导出类型 1 是文本 2 是图片,3 是函数,10 是数字 默认是文本
    double width = 10;//	列宽
    double height = 10;//	列高,后期打算统一使用@ExcelTarget的height,这个会被废弃,注意
    boolean isStatistics = false;//	自动统计数据,在追加一行统计,把所有数据都和输出这个处理会吞没异常,请注意这一点
    boolean isHyperlink = false;//超链接,如果是需要实现接口返回对象
    boolean isImportField = true;//校验字段,看看这个字段是不是导入的Excel中有,如果没有说明是错误的Excel,读取失败,支持name_id
    String exportFormat = "";//	导出的时间格式,以这个是否为空来判断是否需要格式化日期
    String importFormat = "";//导入的时间格式,以这个是否为空来判断是否需要格式化日期
    String format = "";//时间格式,相当于同时设置了exportFormat 和 importFormat
    String databaseFormat = "yyyyMMddHHmmss";//导出时间设置,如果字段是Date类型则不需要设置 数据库如果是string 类型,这个需要设置这个数据库格式,用以转换时间格式输出
    String numFormat = "";//数字格式化,参数是Pattern,使用的对象是DecimalFormat
    int imageType = 1;//	导出类型 1 从file读取 2 是从数据库中读取 默认是文件 同样导入也是一样的
    String suffix = "";//文字后缀,如% 90 变成90%
    boolean isWrap = true;//是否换行 即支持\n
    int[] mergeRely = {};//合并单元格依赖关系,比如第二列合并是基于第一列 则{1}就可以了
    boolean mergeVertical = false;//纵向合并内容相同的单元格

    public ExcelVo() {
    }
}
