package myPackage;

import java.sql.Date;

public class Bean {
	public int p_partkey, p_size;
	public int r_regionkey;
	public int n_nationkey, n_regionkey;
	public int s_suppkey,s_nationkey;
	public int ps_partkey, ps_suppkey, ps_availqty;
	public int c_custkey, c_nationkey;
	public int o_orderkey, o_cuskey, o_shippriority;
	public int l_orderkey, l_partkey, l_suppkey, l_linenumber;
	public double p_retailprice;
	public double s_acctbal;
	public double ps_supplycost;
	public double c_acctbal;
	public double o_totalprice;
	public double l_quantity, l_extendedprice, l_discount, l_tax;
	public String p_name, p_mfgr, p_brand, p_type, p_container, p_comment;
	public String r_name, r_comment;
	public String n_name, n_comment;
	public String s_name, s_address, s_phone, s_comment;
	public String ps_comment;
	public String c_name, c_address, c_phone, c_mktsegment, c_comment;
	public String o_orderstatus, o_orderpriority, o_clerk, o_comment;
	public String l_returnflag, l_linestatus, l_shipinstruct, l_shipmode, l_comment;
	public Date o_orderdate;
	public Date l_shipdate, l_commitdate, l_receiptdate;
  
	public int order_count;
	public int sum_quantity;
	public double revenue;
}
