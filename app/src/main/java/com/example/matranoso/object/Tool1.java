package com.example.matranoso.object;
import com.example.matranoso.object.OSos;
import com.example.matranoso.object.ViTriTao;
import java.util.ArrayList;
import java.util.Random;
public class Tool1 { private String a = " ", b = "+-*/=", c ="1234"; private int e = 5, d = 1000, f = 3, g =0; private String h[][], i[][], j[]; private Random r = new Random(); public int getLever() { 	return e; } public void setLever(int e) { 	this.e = e; } public ArrayList<OSos> getListOHienThi(){ 	return m; } public ArrayList<OSos> getListOBiAn(){ 	return n; } public int getDiem() { 	return g; } private ArrayList<ViTriTao> k = new ArrayList<>(); private ArrayList<OSos> l = new ArrayList<>(); private ArrayList<OSos> m = new ArrayList<>(); private ArrayList<OSos> n = new ArrayList<>(); private boolean q(ViTriTao v){ 	int a = Integer.parseInt(h[v.x+v.xt*0][v.y+v.yt*0]); 	int b = Integer.parseInt(h[v.x+v.xt*2][v.y+v.yt*2]); 	int c = Integer.parseInt(h[v.x+v.xt*4][v.y+v.yt*4]); 	String p1 = h[v.x+v.xt*1][v.y+v.yt*1],p2= h[v.x+v.xt*3][v.y+v.yt*3]; 	int kq=-1,kq2=-1; 	if(p2.contains("=")){ 		kq2=c; 		if(p1.contains("+")){ 			kq=a+b; 		}else if(p1.contains("-")){ 			kq=a-b; 		}else if(p1.contains("*")){ 			kq=a*b; 		}else{ 			if(b==0){ 				return false; 			} 			kq=a/b; 		} 	}else{kq2=a; 		if(p2.contains("+")){ 			kq=c+b; 		}else if(p2.contains("-")){ 			kq=b-c; 		}else if(p2.contains("*")){ 			kq=c*b; 		}else{ 			if(c==0){ 				return false; 			} 			kq=b/c; 		} 	} 	if(kq==kq2){ 		return true; 	}else{ 		return false; 	} } public boolean check(){ 	boolean checkOk = true; 	for(ViTriTao tx: k){ 		if(!q(tx)){ 			checkOk=false; 			break; 		} 	} 	return checkOk; } public void set(int vt,String s){ 	m.get(vt).text = s; 	m.get(vt).taman = false; 	h[vt/ e][vt% e]=s; } public void lamMoi() { 	g =0; 	h = new String[e][e]; 	i = new String[e][e]; 	j = new String[f]; 	k = new ArrayList<>(); 	l.clear(); 	m.clear(); 	n.clear();  	for (int i = 0; i < e; i++) { 		for (int j = 0; j < e; j++) { 			h[i][j] = a; 		} 	} 	for (int i = 0; i < e; i++) { 		for (int j = 0; j < e; j++) { 			this.i[i][j] = a; 		} 	} 	for (int i = 0; i < f; i++) { 		j[i] = a; 	} } public void taoMangPT() { 	int quaTai = 0; 	f =0; 	int n = d; 	do { 		int x = h1(); 		int y = h2(); 		int kq = h3(x, y); 		int xt, yt; 		if (kq == 0) { 			quaTai++; 			if (quaTai >= 300) { 				break; 			} 			continue; 		} else if (kq == 1) { 			xt = 1; 			yt = 0; 		} else if (kq == 2) { 			xt = 0; 			yt = 1; 		} else { 			if (r.nextBoolean()) { 				xt = 1; 				yt = 0; 			} else { 				xt = 0; 				yt = 1; 			} 		} 		if (h4(x, y, xt, yt)) { 			n--; 			quaTai = 0; 		} 	} while (n > 0); } public void chuyenDoiDeHienThi() { 	for (int i = 0; i < e; i++) { 		for (int j = 0; j < e; j++) { 			String s = h[i][j]; 			OSos o = new OSos(); 			o.taman=false; 			o.duocClick =false; 			if(s.contains(" ")){ 				o.hien=false; 			}else{ 				o.hien=true; 			} 			o.text=s; 			l.add(o); 			m.add(o); 		} 	} 	int kl=0; 	String chuanso="0123456789"; 	do{ 		int k =0; 		OSos o; 		boolean ok=true; 		do{k= r.nextInt(m.size()); 		 o = m.get(k); 		if(o.hien){ 			if(o.taman){ 				ok=true; 			}else{ 			String sj = o.text.charAt(0)+""; 			if(chuanso.indexOf(sj)>=0){ 				ok=false; 			}else { 				ok=true; 			}} 		}else{ 			ok=true; 		} 		} 		while (ok); 		OSos os= new OSos(); 		os.taman=false; 		os.duocChon=false; 		os.hien=true; 		os.text = m.get(k).text; 		n.add(os); 		m.get(k).taman = true; 		m.get(k).duocClick = true; 		g++; 		kl++;  	}while (kl< f); /*    for (int i = 0; i < e; i++) { 		for (int j = 0; j < e; j++) { 			String s = h[i][j]; 			System.out.print(s); 			System.out.print(" "); 			for (int z = 0; z < (k - s.length()); z++) { 				System.out.print(" "); 			} 		} 		System.out.println(""); 	}*/ }  private int h1() { 	int k = 0; 	do { 		k = r.nextInt(e); 	} while (k % 2 != 0); 	return k; } private int h2() { 	int k = 0; 	do { 		k = r.nextInt(e); 	} while (k % 2 != 0); 	return k; } private int h3(int x, int y) { 	boolean xb = true, yb = true;  	int xx = x, yy = y; 	int tang = 0; 	if (xx + 4 < e) { 		do { 			xx = x + tang; 			String s = h[xx][yy]; 			if (b.indexOf(s) >= 0) { 				xb = false; 				break; 			} 			tang++; 		} while (tang < 5); 	} else { 		xb = false; 	} 	xx = x; 	yy = y; 	tang = 0; 	if (yy + 4 < e) { 		do { 			yy = y + tang; 			String s = h[xx][yy]; 			if (b.indexOf(s) >= 0) { 				yb = false; 				break; 			} 			tang++; 		} while (tang < 5); 	} else { 		yb = false; 	} 	if (xb && yb) { 		return 3; 	} else if (xb) { 		return 1; 	} else if (yb) { 		return 2; 	} else { 		return 0; 	} } private boolean h4(int x, int y, int xt, int yt) { 	boolean daTao = true; 	String sCheck = ""; 	if (h[x + xt * 0][y + yt * 0].contains(a)) { 		sCheck = sCheck + "0"; 	} else { 		sCheck = sCheck + "1"; 	} 	if (h[x + xt * 2][y + yt * 2].contains(a)) { 		sCheck = sCheck + "0"; 	} else { 		sCheck = sCheck + "1"; 	} 	if (h[x + xt * 4][y + yt * 4].contains(a)) { 		sCheck = sCheck + "0"; 	} else { 		sCheck = sCheck + "1"; 	} 	daTao = true; 	String s = ""; 	if (sCheck.contains("111")) { 		return false; 	} else if (sCheck.contains("000")) { 		s = a1(); 	} else if (sCheck.contains("011")) { 		s = a3(sCheck, Integer.parseInt(h[x + xt * 2][y + yt * 2]), Integer.parseInt(h[x + xt * 4][y + yt * 4])); 	} else if (sCheck.contains("101")) { 		s = a3(sCheck, Integer.parseInt(h[x + xt * 0][y + yt * 0]), Integer.parseInt(h[x + xt * 4][y + yt * 4])); 	} else if (sCheck.contains("110")) { 		s = a3(sCheck, Integer.parseInt(h[x + xt * 0][y + yt * 0]), Integer.parseInt(h[x + xt * 2][y + yt * 2])); 	} else if (sCheck.contains("001")) { 		s = a2(sCheck, Integer.parseInt(h[x + xt * 4][y + yt * 4])); 	} else if (sCheck.contains("100")) { 		s = a2(sCheck, Integer.parseInt(h[x + xt * 0][y + yt * 0])); 	} else { 		s = a2(sCheck, Integer.parseInt(h[x + xt * 2][y + yt * 2])); 	} 	if (s.length() == 0) { 		return false; 	} 	h5(s, x, xt, y, yt); 	return daTao; } private void h5(String s, int x, int xt, int y, int yt) { 	f++; 	k.add(new ViTriTao(x, y, xt, yt)); 	String arrChuoi[] = s.split(a); 	int i = 0; 	do { 		int xx = x + i * xt; 		int yy = y + i * yt; 		h[xx][yy] = arrChuoi[i]; 		i++; 	} while (i < 5); } private int h6() { 	return r.nextInt(10); } private int h7() { 	return r.nextInt(9)+1; } private int h8(int x, int n) { 	if (x == 0 && n == 0) { 		return 0; 	} 	return r.nextInt(x - n) + n; } private int h9(){ 	return Integer.parseInt((""+ c.charAt(r.nextInt(c.length())))); } private String a1() { 	int n = h9(); 	String s = ""; 	switch (n) { 		case 0: 			s = a4(); 			break; 		case 1: 			s = a7(); 			break; 		case 2: 			s = b2(); 			break; 		case 3: 			s = b5(); 			break; 	} 	return s; } private String a2(String dd, int n) { 	int ns= h9(); 	String s = ""; 	switch (ns) { 		case 0: 			s = a5(dd, n); 			break; 		case 1: 			s = a8(dd, n); 			break; 		case 2: 			s = b3(dd, n); 			break; 		case 3: 			s = b6(dd, n); 			break; 	} 	return s; } private String a3(String dd, int n1, int n2) { 	int n = h9(); 	String s = ""; 	switch (n) { 		case 0: 			s = a6(dd, n1, n2); 			break; 		case 1: 			s = a9(dd, n1, n2); 			break; 		case 2: 			s = b4(dd, n1, n2); 			break; 		case 3: 			s = b7(dd, n1, n2); 			break; 	} 	return s; } private String a4() { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	int aa = h6(); 	int bb = h6(); 	int cc = aa + bb; 	if (r.nextBoolean()) { 		a = aa; 		b = bb; 		c = cc; 		p1 = "+"; 		p2 = "="; 	} else { 		a = cc; 		b = bb; 		c = aa; 		p1 = "="; 		p2 = "+"; 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String a5(String dd, int n) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	if (dd.contains("100")) { 		a = n; 		if (r.nextBoolean()) { 			b = h8(a, 0); 			c = a - b; 			p1 = "="; 			p2 = "+"; 		} else { 			b = h6(); 			c = a + b; 			p1 = "+"; 			p2 = "="; 		} 	} else if (dd.contains("010")) { 		b = n; 		if (r.nextBoolean()) { 			a = h6(); 			c = a + b; 			p1 = "+"; 			p2 = "="; 		} else { 			c = h6(); 			a = c + b; 			p1 = "="; 			p2 = "+"; 		} 	} else { 		c = n; 		if (r.nextBoolean()) { 			b = h8(c, 0); 			a = c - b; 			p1 = "+"; 			p2 = "="; 		} else { 			b = h6(); 			a = c + b; 			p1 = "="; 			p2 = "+"; 		} 	}  	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String a6(String dd, int n1, int n2) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = "";  	if (dd.contains("110")) { 		a = n1; 		b = n2; 		boolean k = true; 		if (a > b) { 			k = r.nextBoolean(); 		} else { 			k = true; 		} 		if (k) { 			c = a + b; 			p1 = "+"; 			p2 = "="; 		} else { 			c = a - b; 			p1 = "="; 			p2 = "+"; 		} 	} else if (dd.contains("011")) { 		b = n1; 		c = n2; 		boolean k = true; 		if (c > b) { 			k = r.nextBoolean(); 		} else { 			k = true; 		} 		if (k) { 			a = c + b; 			p1 = "="; 			p2 = "+"; 		} else { 			a = c - b; 			p1 = "+"; 			p2 = "="; 		} 	} else { 		a = n1; 		c = n2; 		if (a > c) { 			b = a - c; 			p1 = "="; 			p2 = "+"; 		} else { 			b = c - a; 			p1 = "+"; 			p2 = "="; 		} 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s;  } private String a7() { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	int aa = h6(); 	int bb = h6(); 	int cc = aa + bb; 	if (r.nextBoolean()) { 		a = aa; 		b = cc; 		c = bb; 		p1 = "="; 		p2 = "-"; 	} else { 		a = cc; 		b = bb; 		c = aa; 		p1 = "-"; 		p2 = "="; 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String a8(String dd, int n) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	if (dd.contains("100")) { 		a = n; 		if (r.nextBoolean()) { 			b = h8(a, 0); 			c = a - b; 			p1 = "-"; 			p2 = "="; 		} else { 			c = h6(); 			b = a + c; 			p1 = "="; 			p2 = "-"; 		} 	} else if (dd.contains("010")) { 		b = n; 		if (r.nextBoolean()) { 			c = h6(); 			a = c + b; 			p1 = "-"; 			p2 = "="; 		} else { 			c = h8(b, 0); 			a = b - c; 			p1 = "="; 			p2 = "-"; 		} 	} else { 		c = n; 		if (r.nextBoolean()) { 			a = h6(); 			b = c + a; 			p1 = "="; 			p2 = "-"; 		} else { 			b = h6(); 			a = c + b; 			p1 = "-"; 			p2 = "="; 		} 	}  	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String a9(String dd, int n1, int n2) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = "";  	if (dd.contains("110")) { 		a = n1; 		b = n2; 		if (a > b) { 			c = a - b; 			p1 = "-"; 			p2 = "="; 		} else { 			c = b - a; 			p1 = "="; 			p2 = "-";  		} 	} else if (dd.contains("011")) { 		b = n1; 		c = n2; 		boolean k = true; 		if (b > c) { 			k = r.nextBoolean(); 		} else { 			k = true; 		} 		if (k) { 			a = c + b; 			p1 = "-"; 			p2 = "="; 		} else { 			a = b - c; 			p1 = "="; 			p2 = "-"; 		} 	} else { 		a = n1; 		c = n2; 		if (a > c) { 			b = a - c; 			p1 = "-"; 			p2 = "="; 		} else { 			b = c + a; 			p1 = "="; 			p2 = "-"; 		} 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s;  } private int b1(int n) { 	if(n==0){ 		return 1; 	} 	String s = ""; 	for (int i = 2; i < n; i++) { 		if (n % i == 0) { 			if (s.length() > 0) { 				s = s + " " + i; 			} else { 				s = "" + i; 			} 		} 	} 	if (s.length() > 0) { 		String arr[] = s.split(" "); 		return Integer.parseInt(arr[r.nextInt(arr.length)]); 	} else { 		return 1; 	} } private String b2() { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	int aa = h6(); 	int bb = h6(); 	int cc = aa * bb; 	if (r.nextBoolean()) { 		a = aa; 		b = bb; 		c = cc; 		p1 = "*"; 		p2 = "="; 	} else { 		a = cc; 		b = bb; 		c = aa; 		p1 = "="; 		p2 = "*"; 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String b3(String dd, int n) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	if (dd.contains("100")) { 		a = n; 		int k = b1(a); 		if (k != 1) { 			b = k; 			c = a / b; 			p1 = "="; 			p2 = "*"; 		} else { 			b = h6(); 			c = a * b; 			p1 = "*"; 			p2 = "="; 		} 	} else if (dd.contains("010")) { 		b = n; 		if (r.nextBoolean()) { 			a = h6(); 			c = a * b; 			p1 = "*"; 			p2 = "="; 		} else { 			c = h6(); 			a = b * c; 			p1 = "="; 			p2 = "*"; 		} 	} else { 		c = n; 		int k = b1(c); 		if (k != 1) { 			b = k; 			a = c / b; 			p1 = "*"; 			p2 = "="; 		} else { 			b = h6(); 			a = c * b; 			p1 = "="; 			p2 = "*"; 		} 	}  	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String b4(String dd, int n1, int n2) { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = "";  	if (dd.contains("110")) { 		a = n1; 		b = n2; 		if (b != 0) { 			if (a % b == 0) { 				c = a / b; 				p1 = "="; 				p2 = "*"; 			} else { 				c = b * a; 				p1 = "*"; 				p2 = "="; 			} 		} else { 			c = b * a; 			p1 = "*"; 			p2 = "="; 		} 	} else if (dd.contains("011")) { 		b = n1; 		c = n2;  		if (b != 0) { 			if (c % b == 0) { 				a = c / b; 				p1 = "*"; 				p2 = "="; 			} else { 				a = b * c; 				p1 = "="; 				p2 = "*"; 			} 		} else { 			a = b * c; 			p1 = "="; 			p2 = "*"; 		} 	} else { 		a = n1; 		c = n2; 		if (c != 0) { 			if (a % c == 0) { 				b = a / c; 				p1 = "="; 				p2 = "*"; 			} else { 				return a3(dd, n1, n2); 			} 		} else if (a != 0) { 			if (c % a == 0) { 				b = c / a; 				p1 = "*"; 				p2 = "="; 			} else { 				return a3(dd, n1, n2); 			} 		} else { 			return a3(dd, n1, n2); 		} 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s;  } private String b5() { 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	int aa = h7(); 	int bb = h7(); 	int cc = aa * bb; 	if (r.nextBoolean()) { 		a = aa; 		b = cc; 		c = bb; 		p1 = "="; 		p2 = "/"; 	} else { 		a = cc; 		b = bb; 		c = aa; 		p1 = "/"; 		p2 = "="; 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String b6(String dd, int n) { 	if(n==0){ 		return a2(dd,n); 	} 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	if (dd.contains("100")) { 		a = n; 		int k = b1(a); 		if (k != 1) { 			b = k; 			c = a / b; 			p1 = "/"; 			p2 = "="; 		} else { 			c = h7(); 			b = c * a; 			p1 = "="; 			p2 = "/"; 		} 	} else if (dd.contains("010")) { 		b = n; 		int k = b1(b); 		if (k != 1) { 			c = k; 			a = b /c; 			p1 = "="; 			p2 = "/"; 		} else { 			c = h7(); 			a = b * c; 			p1 = "/"; 			p2 = "="; 		} 	} else { 		c = n; 		int k = b1(c); 		if (r.nextBoolean()) { 			b = h7(); 			a = c * b; 			p1 = "/"; 			p2 = "="; 		} else { 			a = h7(); 			b = a * c; 			p1 = "="; 			p2 = "/"; 		} 	}  	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s; } private String b7(String dd, int n1, int n2) { 	if(n1*n2==0){ 		return a3(dd,n1,n2); 	} 	int a = 0, b = 0, c = 0; 	String p1 = "", p2 = "", s = ""; 	if (dd.contains("110")) { 		a = n1; 		b = n2; 		if (b != 0) { 			if (a % b == 0) { 				c = a / b; 				p1 = "/"; 				p2 = "="; 			} else { 				if (a != 0&&b % a == 0) { 					c = b / a; 					p1 = "="; 					p2 = "/"; 				}else{ 					return a3(dd, n1, n2); 				} 			} 		} else { 			return a3(dd, n1, n2); 		} 	} else if (dd.contains("011")) { 		b = n1; 		c = n2;  		if (c != 0) { 			if (b %c == 0) { 				a = b / c; 				p1 = "="; 				p2 = "/"; 			} else { 				if(b!=0){ 					a = b * c; 					p1 = "/"; 					p2 = "="; 				}else{ 					return a3(dd, n1, n2); 				} 			} 		} else { 			return a3(dd, n1, n2); 		} 	} else { 		a = n1; 		c = n2; 		if (c != 0&&a!=0) { 			if (a % c == 0) { 				b = a / c; 				p1 = "/"; 				p2 = "="; 			} else { 				b = a* c; 				p1 = "="; 				p2 = "/"; 			} 		} else { 			return a3(dd, n1, n2); 		} 	} 	s = s + a + this.a + p1 + this.a + b + this.a + p2 + this.a + c; 	return s;  } }