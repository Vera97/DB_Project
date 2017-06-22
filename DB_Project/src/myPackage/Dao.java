package myPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

	public List<Bean> MCSQ(int size, String type, String name) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
	    String sql = "select s_acctbal, s_name, n_name, p_partkey, p_mfgr, s_address, s_phone, s_comment " 
			       + "from part, supplier, partsupp, nation, region " 
				   + "where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey " 
				   + "and n_regionkey = r_regionkey and p_size = ? and p_type like ? and r_name = ? " 
				   + "and ps_supplycost=( "
				   + "   select min(ps_supplycost) "
				   + "   from partsupp, supplier, nation, region "
				   + "   where p_partkey = ps_partkey and s_suppkey = ps_suppkey and s_nationkey = n_nationkey " 
				   + "   and n_regionkey = r_regionkey and r_name = ? "
				   + ") "
               	   + "order by s_acctbal desc, n_name, s_name, p_partkey " 
				   + "limit 100;";
	
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, size);
		ptmt.setString(2, "%"+type+"%");
		ptmt.setString(3, name);
		ptmt.setString(4, name);		
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<Bean>();
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.s_acctbal = rs.getDouble("s_acctbal");
			b.s_name = rs.getString("s_name");
			b.n_name = rs.getString("n_name");
			b.p_partkey = rs.getInt("p_partkey");
			b.p_mfgr = rs.getString("p_mfgr");
			b.s_address = rs.getString("s_address");
			b.s_phone = rs.getString("s_phone");
			b.s_comment = rs.getString("s_comment");
			
			bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> OPCQ(String date) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select o_orderpriority, count(*) as order_count "
                   + "from orders "
                   + "where o_orderdate >= date ? and o_orderdate < date ? + interval '3' month "
                   + "and exists( "
                   + "select * from lineitem where l_orderkey = o_orderkey and l_commitdate < l_receiptdate) "
                   + "group by o_orderpriority "
                   + "order by o_orderpriority;";
        
        PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, date);
		ptmt.setString(2, date);

		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.o_orderpriority = rs.getString("o_orderpriority");
			b.order_count = Integer.parseInt(rs.getString("order_count"));
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> RIRQ(String date) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select c_name, c_address, n_name, c_phone, c_acctbal, c_comment, sum(l_extendedprice*(1-l_discount)) as revenue "
                   + "from customer, lineitem, orders, nation "
                   + "where c_custkey = o_custkey and o_orderkey = l_orderkey and c_nationkey = n_nationkey and "
                   + "o_orderdate >= date ? and o_orderdate < date ? + interval '3' month "
                   + "group by c_name, c_address, n_name, c_phone, c_acctbal, c_comment "
                   + "order by revenue desc "
                   + "limit 20;";
        
        PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, date);
		ptmt.setString(2, date);

		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.c_name = rs.getString("c_name");
			b.c_address = rs.getString("c_address");
			b.n_name = rs.getString("n_name");
			b.c_phone = rs.getString("c_phone");
			b.c_acctbal = rs.getDouble("c_acctbal");
			b.c_comment = rs.getString("c_comment");
			b.revenue = rs.getDouble("revenue");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> LVCQ(int quantity) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select c_name, c_custkey, o_orderkey, o_orderdate, o_totalprice, sum(l_quantity) as sum_quantity "
                   + "from customer, orders, lineitem "
                   + "where  o_orderkey in (select l_orderkey from lineitem group by l_orderkey having sum(l_quantity)> ? ) "
                   + "and c_custkey = o_custkey and o_orderkey = l_orderkey "
                   + "group by c_name, c_custkey, o_orderkey, o_orderdate, o_totalprice "
                   + "order by o_totalprice desc, o_orderdate "
                   + "limit 100;";
        
        PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, quantity);

		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.c_name = rs.getString("c_name");
			b.c_custkey = rs.getInt("c_custkey");
			b.o_orderkey = rs.getInt("o_orderkey");
			b.o_orderdate = rs.getDate("o_orderdate");
			b.o_totalprice = rs.getDouble("o_totalprice");
			b.sum_quantity = rs.getInt("sum_quantity");
		    bn.add(b);
		}
		return bn;
	}	

	public List<Bean> RegionQ1(int regionkey, String name, String comment) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from region where r_regionkey = ? and r_name like ? and r_comment like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		ptmt.setInt(1, regionkey);
        ptmt.setString(2, "%"+name+"%");
        ptmt.setString(3, "%"+comment+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.r_regionkey = rs.getInt("r_regionkey");
			b.r_name = rs.getString("r_name");
			b.r_comment = rs.getString("r_comment");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> RegionQ2(String name, String comment) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from region where r_name like ? and r_comment like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, "%"+name+"%");
        ptmt.setString(2, "%"+comment+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.r_regionkey = rs.getInt("r_regionkey");
			b.r_name = rs.getString("r_name");
			b.r_comment = rs.getString("r_comment");
		    bn.add(b);
		}
		return bn;
	}

	public boolean RegionA(String regionkey, String name, String comment)
	{
		Connection conn = JdbcUtil.getConnection();
		String sql = "insert into region values (?,?,?) ";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, Integer.parseInt(regionkey));
			ptmt.setString(2, name);
			ptmt.setString(3, comment);
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean RegionD1(String regionkey, String  name, String comment)
	{
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from region where r_regionkey = ? and r_name like ? and r_comment like ?";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
			ptmt.setInt(1, Integer.parseInt(regionkey));
	        ptmt.setString(2, "%"+name+"%");
	        ptmt.setString(3, "%"+comment+"%");
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	    return true;	
	}
	
	public boolean RegionD2(String  name, String comment)
	{
		Connection conn = JdbcUtil.getConnection();
		String sql = "delete from region where r_name like ? and r_comment like ?";
		PreparedStatement ptmt;
		try {
			ptmt = conn.prepareStatement(sql);
	        ptmt.setString(1, "%"+name+"%");
	        ptmt.setString(2, "%"+comment+"%");
			ptmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	    return true;	
	}
	
	public boolean RegionU1(String regionkey, String regionkey2, String name2, String comment2)
	{
		Connection conn = JdbcUtil.getConnection();
		if(regionkey2!=""){
			String sql = "update region set r_regionkey = ? where r_regionkey = ? ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
		        ptmt.setInt(1, Integer.parseInt(regionkey2));
		        ptmt.setInt(2, Integer.parseInt(regionkey));
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		else if(name2!=""){
			String sql = "update region set r_name = ? where r_regionkey = ? ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
		        ptmt.setString(1, name2);
		        ptmt.setInt(2, Integer.parseInt(regionkey));
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}	
		}
		else if(comment2!=""){
			String sql = "update region set r_comment = ? where r_regionkey = ? ";
			PreparedStatement ptmt;
			try {
				ptmt = conn.prepareStatement(sql);
		        ptmt.setString(1, comment2);
		        ptmt.setInt(2, Integer.parseInt(regionkey));
				ptmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public List<Bean> NationQ(String name) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from nation where n_name like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, "%"+name+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.n_nationkey = rs.getInt("n_nationkey");
			b.n_name = rs.getString("n_name");
			b.n_regionkey = rs.getInt("n_regionkey");
		    b.n_comment = rs.getString("n_comment");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> PartQ(String name) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from part where p_name like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, "%"+name+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.p_partkey = rs.getInt("p_partkey");
			b.p_name = rs.getString("p_name");
			b.p_mfgr = rs.getString("p_mfgr");
		    b.p_brand = rs.getString("p_brand");
		    b.p_type = rs.getString("p_type");
		    b.p_size = rs.getInt("p_size");
		    b.p_container = rs.getString("p_container");
		    b.p_retailprice = rs.getDouble("p_retailprice");
		    b.p_comment = rs.getString("p_comment");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> SupplierQ(String name) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from supplier where s_name like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, "%"+name+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.s_suppkey = rs.getInt("s_suppkey");
			b.s_name = rs.getString("s_name");
			b.s_address = rs.getString("s_address");
		    b.s_nationkey = rs.getInt("s_nationkey");
		    b.s_phone = rs.getString("s_phone");
		    b.s_acctbal = rs.getDouble("s_acctbal");
		    b.s_comment = rs.getString("s_comment");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> PartSuppQ(String partkey) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ptmt;
		if(partkey==""){
			String sql = "select *from partsupp";
		    ptmt = conn.prepareStatement(sql);
	   	}
		else{
		    String sql = "select *from partsupp where ps_partkey = ?";
		    ptmt = conn.prepareStatement(sql);
            ptmt.setInt(1, Integer.parseInt(partkey));
		}
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.ps_partkey = rs.getInt("ps_partkey");
			b.ps_suppkey = rs.getInt("ps_suppkey");
			b.ps_availqty = rs.getInt("ps_availqty");
		    b.ps_supplycost = rs.getDouble("ps_supplycost");
		    b.ps_comment = rs.getString("ps_comment");
		    bn.add(b);
		}
		return bn;
	}
	
	public List<Bean> CustomerQ(String name) throws SQLException{
		Connection conn = JdbcUtil.getConnection();
		String sql = "select *from customer where c_name like ?";
		PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, "%"+name+"%");
		
		ResultSet rs = ptmt.executeQuery();
		List<Bean> bn = new ArrayList<>();	
		Bean b = null;
		while(rs.next()){
			b = new Bean();
			b.c_custkey = rs.getInt("c_custkey");
			b.c_name = rs.getString("c_name");
			b.c_address = rs.getString("c_address");
		    b.c_nationkey = rs.getInt("c_nationkey");
		    b.c_phone = rs.getString("c_phone");
		    b.c_acctbal = rs.getDouble("c_acctbal");
		    b.c_mktsegment = rs.getString("c_mktsegment");
		    b.c_comment = rs.getString("c_comment");
		    bn.add(b);
		}
		return bn;
	}
	
}
