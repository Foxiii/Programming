function [z] = neville(pi,pik,xi,xik)



z = pi + (1.55-xi)/(xi-xik) * (pi - pik);

z

end