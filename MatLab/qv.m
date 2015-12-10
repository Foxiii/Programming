function [x] = qv(v,b)

x = b- (2*v*v') ./ (v'*v) *b


end

