package mybatis.framework.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * mybatis LocalDateTime转换
 */
@MappedTypes(LocalDateTime.class)
public class LocalDateTimeTypeHandler extends BaseTypeHandler<LocalDateTime> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LocalDateTime localDateTime, JdbcType jdbcType) throws SQLException {
        preparedStatement.setTimestamp(i, Timestamp.valueOf(localDateTime));
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(s);
        if (timestamp == null) {
            return null;
        } else {
            return timestamp.toLocalDateTime();
        }
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Timestamp timestamp = resultSet.getTimestamp(i);
        if (timestamp == null) {
            return null;
        } else {
            return timestamp.toLocalDateTime();
        }
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Timestamp timestamp = callableStatement.getTimestamp(i);
        if (timestamp == null) {
            return null;
        } else {
            return timestamp.toLocalDateTime();
        }
    }
}
